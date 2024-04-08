package no.nav.utsjekk.kontrakter.iverksett

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.utsjekk.kontrakter.felles.BrukersNavKontor
import no.nav.utsjekk.kontrakter.felles.GyldigBehandlingId
import no.nav.utsjekk.kontrakter.felles.GyldigSakId
import no.nav.utsjekk.kontrakter.felles.Personident
import java.time.LocalDateTime

data class IverksettDto(
    @GyldigSakId
    val sakId: String,
    @GyldigBehandlingId
    val behandlingId: String,
    @Schema(required = true, description = "Fødselsnummer eller D-nummer", example = "15507600333", type = "string")
    val personident: Personident,
    @Schema(description = "Må være satt for utbetalingsvedtak")
    val vedtak: VedtaksdetaljerDto =
        VedtaksdetaljerDto(
            vedtakstidspunkt = LocalDateTime.now(),
            saksbehandlerId = "",
            beslutterId = "",
        ),
    @Schema(description = "Må være satt hvis det ikke er første iverksetting på saken")
    val forrigeIverksetting: ForrigeIverksettingDto? = null,
) {
    init {
        GyldigSakId.valider(sakId)
        GyldigBehandlingId.valider(behandlingId)
    }
}

data class VedtaksdetaljerDto(
    @Schema(required = true)
    val vedtakstidspunkt: LocalDateTime,
    @Schema(
        required = true,
        description = "NAV-ident til saksbehandler, eller servicebruker til applikasjon dersom vedtaket er fattet fullautomatisk",
        pattern = "^[A-Z]\\d{6}\$",
        example = "Z123456",
    )
    val saksbehandlerId: String,
    @Schema(
        required = true,
        description = "NAV-ident til beslutter, eller servicebruker til applikasjon dersom vedtaket er fattet fullautomatisk",
        pattern = "^[A-Z]\\d{6}\$",
        example = "Z123456",
    )
    val beslutterId: String,
    @Schema(
        required = false,
        description = "Settes kun for tiltakspenger",
    )
    val brukersNavKontor: BrukersNavKontor? = null,
    @Schema(required = false)
    val utbetalinger: List<UtbetalingDto> = emptyList(),
)

@Suppress("unused")
enum class IverksettStatus {
    SENDT_TIL_OPPDRAG,
    FEILET_MOT_OPPDRAG,
    OK,
    IKKE_PÅBEGYNT,
    OK_UTEN_UTBETALING,
}

data class ForrigeIverksettingDto(
    @GyldigBehandlingId
    val behandlingId: String,
) {
    init {
        GyldigBehandlingId.valider(behandlingId)
    }
}
