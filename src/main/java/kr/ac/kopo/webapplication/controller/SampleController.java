package kr.ac.kopo.webapplication.controller;


import org.springframework.ui.Model;
import kr.ac.kopo.webapplication.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex1")
    public void ex(){

    }

    @GetMapping({"/ex2", "/ex2_1", "/exBlock", "/exLink"})
    public void exModel(Model model){
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                    .sno(i)
                    .first("First.." + i)
                    .last("Last.." + i)
                    .regTime(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList());

    model.addAttribute("list", list);
    }

    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes){

        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("First..100")
                .last("Last..100")
                .regTime(LocalDateTime.now())
                .build();
        redirectAttributes.addFlashAttribute("result", "succes");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/ex3";  //맘대로 바꾸면 안됨
    }

    @GetMapping("/ex3")
    public void ex3(){

    }
    @GetMapping({"/exLayout1", "/exLayout2","/exTamplate", "/exSidebar"})
    public void exLayout1(){

    }

}
