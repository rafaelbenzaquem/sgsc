package com.rafaelbenz.sgsc.modelo.enums;

public enum TipoCliente {
    PESSOA_FISICA(0,"PESSOA_FISICA"),
    PESSOA_JURIDICA(1,"Pessoa jurídica");

    private int codigo;
    private String descricao;

    private TipoCliente(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer codigo){
        if(codigo==null)
            return null;

        for(TipoCliente tc : TipoCliente.values())
            if(codigo.equals(tc.codigo))
                return tc;

        throw new IllegalArgumentException("Código inválido: "+codigo);
    }
    
    public static TipoCliente toEnum(String descricao){
        if(descricao==null)
            return null;

        for(TipoCliente tc : TipoCliente.values())
            if(descricao.equals(tc.descricao))
                return tc;

        throw new IllegalArgumentException("Descrição inválida: "+descricao);
    }
}