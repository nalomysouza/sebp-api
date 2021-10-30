package oas.nalomy.sebpapi.base.payload.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnabledRequest {
	@NotNull
	@Positive
	private long id;

	@NotNull
	private boolean enabledOrDisabled;

}
