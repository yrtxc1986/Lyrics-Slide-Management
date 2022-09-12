package idv.wilson.church.lyricsslidemanagement.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.wilson.church.lyricsslidemanagement.dto.lyrics.LyricsRequest;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsEntity;
import idv.wilson.church.lyricsslidemanagement.persistence.lyrics.LyricsListItem;
import idv.wilson.church.lyricsslidemanagement.service.LyricsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lyrics")
@RequiredArgsConstructor
public class LyricsController {

  private final LyricsService service;
    
    
  @GetMapping
  public List<LyricsListItem> getList(){
    
    return service.getList();
  }

  @GetMapping("{id}")
  public LyricsEntity getDetial(@PathVariable UUID id){
    return service.getDetial(id);
  }

  @PostMapping
  public UUID create(@RequestBody LyricsRequest data){
    UUID id = service.create(data);
    return id;
  }

  @PutMapping("{id}")
  public void updateById(@PathVariable UUID id, @RequestBody LyricsRequest data){
    service.update(id, data);
  }

  @GetMapping("{id}/download")
  public void download(@PathVariable UUID id){
      
  }

}
