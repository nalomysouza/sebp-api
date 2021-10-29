package oas.nalomy.sebpapi.repository.help;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import oas.nalomy.sebpapi.domain.help.Mesorregiao;
import oas.nalomy.sebpapi.domain.help.Microrregiao;
import oas.nalomy.sebpapi.domain.help.Municipio;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class MunicipioRepository {

	public List<Municipio> getMunicipios() {
		return getJson().stream().map(m -> new Municipio(m.getId(), m.getNome())).collect(Collectors.toList());
	}

	public List<Microrregiao> getMicrorregioes() {
		return getJson().stream()
				.map(m -> new Microrregiao(m.getMicrorregiao().getId(), m.getMicrorregiao().getNome()))
				.distinct().collect(Collectors.toList());
	}

	public List<Mesorregiao> getMesorregioes() {
		return getJson().stream()
				.map(m -> new Mesorregiao(m.getMicrorregiao().getMesorregiao().getId(),
				m.getMicrorregiao().getMesorregiao().getNome())).distinct().collect(Collectors.toList());
	}

	private List<Municipio> getJson() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Municipio>> typeReference = new TypeReference<List<Municipio>>() { };
		try {
			InputStream inputStream = TypeReference.class.getResourceAsStream("/db/json/municipios.json");
			List<Municipio> result = mapper.readValue(inputStream, typeReference);
			return result;
		} catch (IOException e) {
			return Collections.emptyList();
		}
	}
}
