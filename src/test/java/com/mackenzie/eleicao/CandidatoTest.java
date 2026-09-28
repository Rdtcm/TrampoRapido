package com.mackenzie.eleicao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CandidatoTest {

    private Candidato novoCandidato() {
        return new Candidato(1, "João Silva", "joao@email.com", "11999999999", LocalDate.of(2000, 5, 10));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void rejeitarNomeInvalido(String nome) {
        Candidato candidato = novoCandidato();
        candidato.setNome(nome);
        assertThrows(IllegalArgumentException.class, candidato::validarNome);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n", "joaoemail.com"})
    void rejeitarEmailInvalido(String email) {
        Candidato candidato = novoCandidato();
        candidato.setEmail(email);
        assertThrows(IllegalArgumentException.class, candidato::validarEmail);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n", "11999abc999", "11 999999999", "11999-99999", "+5511999999999"})
    void rejeitarTelefoneInvalido(String telefone) {
        Candidato candidato = novoCandidato();
        candidato.setTelefone(telefone);
        assertThrows(IllegalArgumentException.class, candidato::validarTelefone);
    }

    @Test
    void atualizarEmailCorretamente() {
        Candidato candidato = novoCandidato();
        candidato.atualizarEmail("novo@email.com");
        assertEquals("novo@email.com", candidato.getEmail());
        assertTrue(candidato.possuiEmail("novo@email.com"));
        assertFalse(candidato.possuiEmail("joao@email.com"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void rejeitarAtualizacaoInvalidaSemAlterarEmail(String email) {
        Candidato candidato = novoCandidato();
        assertThrows(IllegalArgumentException.class, () -> candidato.atualizarEmail(email));
        assertEquals("joao@email.com", candidato.getEmail());
    }

    @Test
    void compararEmail() {
        Candidato candidato = novoCandidato();
        assertTrue(candidato.possuiEmail("joao@email.com"));
        assertFalse(candidato.possuiEmail("outro@email.com"));
        assertFalse(candidato.possuiEmail(null));
    }

    @Test
    void InstanciarCandidatoCorretamenteTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joao@email.com", "11999999999", LocalDate.of(2000, 5, 10));

        assertEquals(1, candidato.getIdCandidato());
        assertEquals("João Silva", candidato.getNome());
        assertEquals("joao@email.com", candidato.getEmail());
        assertEquals("11999999999", candidato.getTelefone());
        assertEquals(LocalDate.of(2000, 5, 10), candidato.getDataNascimento());
    }

    @Test
    void ValidarNomeTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joao@email.com", "11999999999", LocalDate.of(2000, 5, 10));

        assertDoesNotThrow(() -> candidato.validarNome());
    }

    @Test
    void NomeNaoVazioTeste() {

        Candidato candidato = new Candidato(1, "", "joao@email.com", "11999999999", LocalDate.of(2000, 5, 10));

        assertThrows(IllegalArgumentException.class, () -> candidato.validarNome());
    }

    @Test
    void ValidarEmailTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joao@email.com", "11999999999", LocalDate.of(2000, 5, 10));

        assertDoesNotThrow(() -> candidato.validarEmail());
    }

    @Test
    void EmailSemArrobaTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joaoemail.com", "11999999999", LocalDate.of(2000, 5, 10));

        assertThrows(IllegalArgumentException.class, () -> candidato.validarEmail());
    }

    @Test
    void ValidarTelefoneTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joao@email.com", "11999999999", LocalDate.of(2000, 5, 10));

        assertDoesNotThrow(() -> candidato.validarTelefone());
    }

    @Test
    void TelefoneComLetrasTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joao@email.com", "11999abc999", LocalDate.of(2000, 5, 10));

        assertThrows(IllegalArgumentException.class, () -> candidato.validarTelefone());
    }

    @Test
    void ValidarDataNascimentoTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joao@email.com", "11999999999", LocalDate.of(2000, 5, 10));

        assertDoesNotThrow(() -> candidato.validarDataNascimento());
    }

    @Test
    void DataNascimentoNulaTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joao@email.com", "11999999999", null);

        assertThrows(IllegalArgumentException.class, () -> candidato.validarDataNascimento());
    }
    
    @Test
    void AlterarTodosOsCamposTeste() {

        Candidato candidato = new Candidato(1, "João Silva", "joao@email.com", "11999999999", LocalDate.of(2000, 5, 10));

        candidato.setIdCandidato(2);
        candidato.setNome("Carlos Santos");
        candidato.setEmail("carlos@email.com");
        candidato.setTelefone("11888888888");
        candidato.setDataNascimento(LocalDate.of(1999, 8, 20));

        assertEquals(2, candidato.getIdCandidato());
        assertEquals("Carlos Santos", candidato.getNome());
        assertEquals("carlos@email.com", candidato.getEmail());
        assertEquals("11888888888", candidato.getTelefone());
        assertEquals(LocalDate.of(1999, 8, 20), candidato.getDataNascimento());
    }
}

