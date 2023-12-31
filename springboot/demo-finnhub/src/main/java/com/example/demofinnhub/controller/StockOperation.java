package com.example.demofinnhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.infra.ApiResponse;
import com.example.demofinnhub.model.dto.web.resp.StockDTO;

public interface StockOperation {

  @GetMapping(value = "/stock")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<StockDTO> stockInfo(@RequestParam("symbol") String symbol)
      throws FinnhubException;

  // @GetMapping(value = "/stockfromdb")
  // @ResponseStatus(value = HttpStatus.OK)
  // ApiResponse<StockDTO> stockInfoFromDb(@RequestParam("symbol") String symbol)
  //     throws FinnhubException;
}
