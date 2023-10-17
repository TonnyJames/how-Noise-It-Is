package com.projetointegrador.hownoiseitis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Document
public class InfoDb {

    @Id
    private String id;
    private String nomeDispositivo;
//    @JsonFormat(pattern = "dd-MM-yyyy@HH:mm:ss", locale = "pt_BR")
    private LocalDateTime data;
    private Integer valor;

    public InfoDb(String id, String nomeDispositivo, Integer valor) {
        this.id = id;
        this.nomeDispositivo = nomeDispositivo;
        this.data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoDb infoDb = (InfoDb) o;
        return Objects.equals(id, infoDb.id) && Objects.equals(nomeDispositivo, infoDb.nomeDispositivo) && Objects.equals(data, infoDb.data) && Objects.equals(valor, infoDb.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeDispositivo, data, valor);
    }

    @Override
    public String toString() {
        return "InfoDb{" +
                "id='" + id + '\'' +
                ", nomeDispositivo='" + nomeDispositivo + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                '}';
    }
}
