package com.jamal.pfe.backend.common.mapper;

import com.jamal.pfe.backend.port.entity.Port;
import com.jamal.pfe.backend.port.dto.PortRequest;
import com.jamal.pfe.backend.port.dto.PortResponse;

public class PortMapper {

    public static Port toEntity(PortRequest req) {
        Port p = new Port();
        p.setNom(req.getNom());
        p.setPays(req.getPays());
        p.setCode(req.getCode());
        return p;
    }

    public static PortResponse toResponse(Port p) {
        PortResponse r = new PortResponse();
        r.setId(p.getId());
        r.setNom(p.getNom());
        r.setPays(p.getPays());
        r.setCode(p.getCode());
        return r;
    }
}