package edu.mum.waa.backend.meditation.ws.controller;

import edu.mum.waa.backend.meditation.ws.controller.crud.RestCrudController;
import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.TmRetreat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud/blocks")
@PreAuthorize("hasRole('USER')")
public class BlockController extends RestCrudController<Block> {
    private static final Logger logger = LoggerFactory.getLogger(BlockController.class);
}
