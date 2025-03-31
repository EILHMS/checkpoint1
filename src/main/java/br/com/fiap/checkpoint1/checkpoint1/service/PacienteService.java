package br.com.fiap.checkpoint1.checkpoint1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint1.checkpoint1.dto.PacienteRequestCreate;
import br.com.fiap.checkpoint1.checkpoint1.dto.PacienteRequestUpdate;
import br.com.fiap.checkpoint1.checkpoint1.model.Paciente;

@Service
public class PacienteService {

    private Long sequence = 1L;
    private List<Paciente> pacientes = new ArrayList<>();

    public Paciente create(PacienteRequestCreate dto) {
        Paciente paciente = new Paciente();
        paciente.setId(sequence++);
        paciente.setNome(dto.getNome());
        paciente.setEndereco(dto.getEndereco());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefone(dto.getTelefone());
        pacientes.add(paciente);
        return paciente;
    }

    public Optional<Paciente> updatePaciente(Long id, PacienteRequestUpdate dto) {
        return pacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst()
                .map(p -> {
                    p.setEndereco(dto.getEndereco());
                    p.setBairro(dto.getBairro());
                    p.setEmail(dto.getEmail());
                    p.setTelefone(dto.getTelefone());
                    return p;
                });
    }

    public Optional<Paciente> getById(Long id) {
        return pacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst();

    }

    public List<Paciente> getAll() {
        return pacientes;
    }

    public boolean delete(Long id) {
        return pacientes.removeIf(paciente -> paciente.getId().equals(id));
    }
}
