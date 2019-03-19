package com.ceiba.induccion.infraestructura.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.dominio.port.RegistroRepository;
import com.ceiba.induccion.infraestructura.entidad.RegistroEntity;
import com.ceiba.induccion.infraestructura.mapper.RegistroMapper;

@Repository
public class RegistroRepositoryAdapter implements RegistroRepository {

	private static final int CERO_VEHICULOS_ENCONTRADOS = 0;

	@Autowired
	private RegistroRepositoryData registroRepositoryData;

	@Autowired
	private RegistroMapper registroMapper;

	@Override
	public Registro save(Registro registro) {
		RegistroEntity registroEntity = registroRepositoryData.save(registroMapper.mapToEntity(registro));
		registro.setId(registroEntity.getId());
		return registro;
	}

	@Override
	public Registro findById(long id) {
		Registro registro = null;
		Optional<RegistroEntity> opcional = registroRepositoryData.findById(id);
		if (opcional.isPresent()) {
			registro = registroMapper.mapToDomain(opcional.get());
		}
		return registro;
	}

	@Override
	public int contarVehiculosEstacionados(TipoVehiculoEnum tipoVehiculo) {
		return registroRepositoryData.contarVehiculosEstacionados(tipoVehiculo);
	}

	@Override
	public boolean existeVehiculoEnEstacionamiento(String placa) {
		return registroRepositoryData.contarVehiculosEstacionadosConPlaca(placa) > CERO_VEHICULOS_ENCONTRADOS;
	}

	@Override
	public List<Registro> listarVehiculosEstacionados() {
		return registroMapper.mapToDomain(registroRepositoryData.findByFinIsNull());
	}

}
