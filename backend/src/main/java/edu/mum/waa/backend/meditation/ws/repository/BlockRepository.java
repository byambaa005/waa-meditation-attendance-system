package edu.mum.waa.backend.meditation.ws.repository;

import edu.mum.waa.backend.meditation.ws.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BlockRepository extends JpaRepository<Block,Integer> {

}
