package com.pucminas.sgq.qualitytransparence.service;

import com.pucminas.sgq.qualitytransparence.vo.IncidentVO;
import com.pucminas.sgq.qualitytransparence.vo.ProblemVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sgq-api-gateway", url = "http://localhost:8080/api/v1")
public interface SgqAPIGatewayRestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/problem/{id}")
    ProblemVO getProblemById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/incident/{id}")
    IncidentVO getIncidentById(@PathVariable("id") Long id);

}
