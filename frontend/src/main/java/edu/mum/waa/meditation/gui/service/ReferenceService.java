package edu.mum.waa.meditation.gui.service;

import edu.mum.waa.meditation.gui.model.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Service
public class ReferenceService {
    private static String BLOCKS_URL = "http://localhost:8082/crud/blocks";

//    @Autowired
//    HttpSession httpSession;

    public HttpHeaders buildHeader(HttpSession session){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + session.getAttribute("access_token"));
        return headers;
    }

    public Collection<Block>  getBlocks(HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        //Get blocks list
        ResponseEntity<PagedResources<Block>> blocksResponse = restTemplate.exchange(BLOCKS_URL,
                HttpMethod.GET, new HttpEntity<>("parameters", buildHeader(session)), new ParameterizedTypeReference<PagedResources<Block>>() {
                });
        PagedResources<Block> Block = blocksResponse.getBody();
        Collection<Block> blocks = Block.getContent();
        return blocks;
    }

    public Collection<Block>  getBlockReports(Long blockId, HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        //Get blocks list
        ResponseEntity<PagedResources<Block>> blocksResponse = restTemplate.exchange(BLOCKS_URL,
                HttpMethod.GET, new HttpEntity<>("parameters", buildHeader(session)), new ParameterizedTypeReference<PagedResources<Block>>() {
                });
        PagedResources<Block> Block = blocksResponse.getBody();
        Collection<Block> blocks = Block.getContent();
        return blocks;
    }
}
