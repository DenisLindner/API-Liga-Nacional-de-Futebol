package com.denis.api.lnf.model.empresa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmpresaRequestDTO(@NotBlank String nomeEmpresarial, @NotBlank String nomeFicticio, @NotBlank @Size(min = 7) String cnpj) {
}
