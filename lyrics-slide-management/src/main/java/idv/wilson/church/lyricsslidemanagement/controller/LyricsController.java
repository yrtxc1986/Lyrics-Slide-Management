package idv.wilson.church.lyricsslidemanagement.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.wilson.church.lyricsslidemanagement.dto.lyrics.LyricsRequest;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsListItem;
import idv.wilson.church.lyricsslidemanagement.service.LyricsService;
import idv.wilson.church.lyricsslidemanagement.service.SlideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/lyrics")
@RequiredArgsConstructor
public class LyricsController {

  private final LyricsService lyricsService;
  private final SlideService slideService;
    
    
  @GetMapping
  public List<LyricsListItem> getList(@RequestParam(required = false) String code, @RequestParam(required = false) Integer length){
    if(length != null){
      log.trace("Length enter:"+length);
    }
    if(code != null){
      log.trace("code enter:"+code);
    }
    return lyricsService.getList();
  }

  @GetMapping("{id}")
  public LyricsEntity getDetial(@PathVariable UUID id){
    return lyricsService.getDetial(id);
  }

  @PostMapping
  public UUID create(@RequestBody LyricsRequest data){
    UUID id = lyricsService.create(data);
    return id;
  }

  @PutMapping("{id}")
  public void updateById(@PathVariable UUID id, @RequestBody LyricsRequest data){
    lyricsService.update(id, data);
  }

  
  @GetMapping("{id}/download")
  public ResponseEntity<InputStreamResource> download(@PathVariable UUID id) throws IOException {
    LyricsEntity entity = lyricsService.getDetial(id);
    
    Path tempPPTX = slideService.createLyricsSide(entity);
    HttpHeaders headers = new HttpHeaders();
    
    String filename = entity.getName()+".pptx";
    headers.setContentDispositionFormData("attachment", new String(filename.getBytes("UTF-8"),"iso-8859-1"));
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

    InputStream inputStream = Files.newInputStream(tempPPTX);
    InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
    headers.setContentLength(Files.size(tempPPTX));
    return new ResponseEntity<InputStreamResource>(inputStreamResource, headers, HttpStatus.OK);
  }

}
