package idv.wilson.church.lyricsslidemanagement.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import idv.wilson.church.lyricsslidemanagement.dto.lyrics.LyricsRequest;
import idv.wilson.church.lyricsslidemanagement.dto.lyrics.LyricsTitle;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.service.LyricsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j; 

@Slf4j
@RestController
@RequestMapping("/lyrics")
@RequiredArgsConstructor
public class LyricsController {

  private final LyricsService service;
    
    
  @GetMapping
  public List<LyricsTitle> getList(){
    
    return service.getList();
  }

  @GetMapping("{id}")
  public LyricsEntity getDetial(@PathVariable UUID id){
    return service.getDetial(id);
  }

  @PostMapping
  public String create(@RequestBody LyricsRequest data){
    log.debug("Create with Body:{}", data.getPages()[0][0]);
    return "done";
  }

  @PutMapping("{id}")
  public String updateById(@PathVariable UUID id, @RequestBody LyricsRequest data){
    log.debug("Create with Body:{}", data.getPages()[0][0]);
    return "done";
  }

  @GetMapping("{id}/download")
  public void download(@PathVariable UUID id){

  }

  @GetMapping("import")
  public void getImportSamepe(){
    
  }
  @PostMapping("import")
  public void importExcel(MultipartFile file) throws IOException {

  }

}
