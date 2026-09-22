package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
    private final SalaRepository salaRepository;

    private final SalaMapper salaMapper;

    public SalaService(SalaRepository salaRepository, SalaMapper salaMapper){
        this.salaRepository = salaRepository;
        this.salaMapper = salaMapper;
    }

    public List<SalaResponseDTO> listarSalasAtivas(){
        var salas = salaRepository.findByDataExclusaoIsNull();
        return salaMapper.toResponseDTO(salas);
    }
}
