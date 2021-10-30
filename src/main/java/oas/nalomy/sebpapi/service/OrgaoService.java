package oas.nalomy.sebpapi.service;

import oas.nalomy.sebpapi.base.generic.GenericServiceCrudImpl;
import oas.nalomy.sebpapi.domain.Orgao;
import oas.nalomy.sebpapi.repository.OrgaoRepository;
import org.springframework.stereotype.Service;

@Service
public class OrgaoService extends GenericServiceCrudImpl<Orgao, OrgaoRepository> {
}
