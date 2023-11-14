package com.projetointegrador.hownoiseitis.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class InfoDb {

    @Id
    private String id;
    private String nomeDispositivo;
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSD", locale = "pt_BR")
    private LocalDateTime data;
    private Integer valor;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public InfoDb(@JsonProperty("id")String id, @JsonProperty("nomeDispositivo") String nomeDispositivo, @JsonProperty("valor") Integer valor) {
        this.id = id;
        this.nomeDispositivo = nomeDispositivo;
        this.data = LocalDateTime.now();
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
