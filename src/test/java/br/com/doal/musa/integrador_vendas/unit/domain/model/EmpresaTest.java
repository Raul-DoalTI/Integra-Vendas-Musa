package br.com.doal.musa.integrador_vendas.unit.domain.model;

import br.com.doal.musa.integrador_vendas.domain.exceptions.validacao.CampoInvalidoException;
import br.com.doal.musa.integrador_vendas.domain.model.Empresa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    void criarEmpresa_validaCamposComSucesso() {
        Empresa e = Empresa.criar(1L, "Fantasia", "Razao", "12.345.678/0001-90");
        assertEquals(1L, e.getId());
        assertEquals("Fantasia", e.getNomeFantasia());
        assertTrue(e.getCgcCpf().matches("\\d+"));
    }

    @Test
    void criarEmpresa_comCpfInvalido_deveFalhar() {
        CampoInvalidoException ex = assertThrows(CampoInvalidoException.class,
                () -> Empresa.criar(2L, "Nome", "Razao", "123"));
        assertTrue(ex.getMessage().contains("CGC/CPF inválido"));
    }

    @Test
    void criarEmpresa_camposVazios_deveFalhar() {
        assertThrows(IllegalArgumentException.class, () -> Empresa.criar(null, "a", "b", "12345678901"));
        assertThrows(CampoInvalidoException.class, () -> Empresa.criar(1L, "", "b", "12345678901"));
    }
}
