package com.MisterInfo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MisterInfo.Model.Aparelhos;

@Repository
public interface AparelhosRepository extends JpaRepository<Aparelhos, Long>  {

}
