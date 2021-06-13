package com.example.MarvelAPIApp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.example.MarvelAPIApp.Model.MarvelAPIModel;

@Repository
public interface MarvelAPIRepository extends JpaRepository<MarvelAPIModel,Long>{

}
