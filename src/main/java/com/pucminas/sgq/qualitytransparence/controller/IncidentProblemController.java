package com.pucminas.sgq.qualitytransparence.controller;

import com.pucminas.sgq.qualitytransparence.service.IncidentProblemService;
import com.pucminas.sgq.qualitytransparence.vo.IncidentProblemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class IncidentProblemController {

    @Autowired
    private IncidentProblemService incidentProblemService;

    @PostMapping("/incidentProblem")
    public ResponseEntity<IncidentProblemVO> createIncident(@RequestBody IncidentProblemVO incidentProblemVO) {
        try {
            incidentProblemService.publishIncidentProblem(incidentProblemVO);
            return new ResponseEntity<>(incidentProblemVO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
