package com.denis.api.lnf.model.empresa;

import java.util.UUID;

public record EmpresaResponse(UUID id, String nomeEmpresarial, String nomeFicticio, String cnpj) {
}
