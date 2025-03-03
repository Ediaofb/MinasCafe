package com.minascafe.api.record;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record DadosAtualizacaoCafeCoco(
       @NotNull
       Integer lote,
       String produtor,
       LocalDate data,
       String status,
       Integer catacao,
       Integer sacos,
       Float quilos,
       String subproduto,
       String classificacao,
       Float humidade,
       String lancado,
       String baixado,
       String meieiro,
       Integer barracao,
       Integer numero_nota,
       String observacoes,
       String referencia,
       Integer peneira,
       Integer porcentagem_meieiro,
       Integer porcentagem_produtor) {
}