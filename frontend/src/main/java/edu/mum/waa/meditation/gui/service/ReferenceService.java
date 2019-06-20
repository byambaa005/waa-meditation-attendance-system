package edu.mum.waa.meditation.gui.service;

import edu.mum.waa.meditation.gui.model.AttendDetailReport;
import edu.mum.waa.meditation.gui.model.AttendanceReport;
import edu.mum.waa.meditation.gui.model.Block;
import edu.mum.waa.meditation.gui.model.BlockSummaryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Service
public class ReferenceService {
    private static String BLOCKS_URL = "http://localhost:8082/crud/blocks";
    private static String ENTRIES_URL = "http://localhost:8082/student/getEntries";
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
    public Collection<String>  getEntries(HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        //Get blocks list
        ResponseEntity<List<String>> blocksResponse = restTemplate.exchange(ENTRIES_URL,
                HttpMethod.GET, new HttpEntity<>("parameters", buildHeader(session)), new ParameterizedTypeReference<List<String>>() {
                });
        List<String> lists = blocksResponse.getBody();
        return lists;
    }
    public BlockSummaryReport  getBlockReports(Long blockId, HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        String studentAttendanceByBlockUrl = "http://localhost:8082/api/user/attendance-block-summary?blockId=" + blockId;
        ResponseEntity<BlockSummaryReport> blockResponse = restTemplate.exchange(studentAttendanceByBlockUrl,
                HttpMethod.GET, new HttpEntity<>("parameters", buildHeader(session)), new ParameterizedTypeReference<BlockSummaryReport>() {});
        BlockSummaryReport studentAttendanceByBlockResponses = blockResponse.getBody();

        return studentAttendanceByBlockResponses;
    }

    public BlockSummaryReport  getEntryReports(String entry, HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        String studentAttendanceByBlockUrl = "http://localhost:8082/api/user/attendance-entry-summary?entry=" + entry;
        ResponseEntity<BlockSummaryReport> blockResponse = restTemplate.exchange(studentAttendanceByBlockUrl,
                HttpMethod.GET, new HttpEntity<>("parameters", buildHeader(session)), new ParameterizedTypeReference<BlockSummaryReport>() {});
        BlockSummaryReport studentAttendanceByBlockResponses = blockResponse.getBody();

        return studentAttendanceByBlockResponses;
    }
}
