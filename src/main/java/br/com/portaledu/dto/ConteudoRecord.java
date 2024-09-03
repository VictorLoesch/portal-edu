package br.com.portaledu.dto;

import br.com.portaledu.model.Modulo;
import br.com.portaledu.model.TipoConteudo;

public record ConteudoRecord(TipoConteudo tipo, String titulo,String url,Modulo modulo) {

}
