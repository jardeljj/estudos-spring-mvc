package com.jardelDev.boot.web.controller;

import com.jardelDev.boot.domain.Cargo;
import com.jardelDev.boot.domain.Funcionario;
import com.jardelDev.boot.domain.UF;
import com.jardelDev.boot.service.CargoService;
import com.jardelDev.boot.service.FuncionarioService;
import com.jardelDev.boot.web.controller.validator.FuncionarioValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

@Controller
@RequestMapping("funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new FuncionarioValidator());
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        return "funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "funcionario/cadastro";
        }

        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "funcionario/cadastro";
        }

        funcionarioService.editar(funcionario);
        attr.addFlashAttribute("success", "Funcionário editado com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        funcionarioService.excluir(id);
        attr.addFlashAttribute("success", "Funcionário removido com sucesso.");
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
        return "funcionario/lista";
    }

    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
        return "funcionario/lista";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos() {
        return cargoService.buscarTodos();
    }

    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam(name = "entrada", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam(name = "saida", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarPorDatas(entrada,saida));
        return "funcionario/lista";
    }


    @ModelAttribute("ufs")
    public UF[] getUFs() {
        return UF.values();
    }

}
