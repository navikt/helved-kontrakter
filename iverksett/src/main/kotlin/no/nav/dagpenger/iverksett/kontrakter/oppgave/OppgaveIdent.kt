package no.nav.dagpenger.iverksett.kontrakter.oppgave

data class OppgaveIdentV2(val ident: String?, val gruppe: IdentGruppe?)

enum class IdentGruppe {
    AKTOERID,
    FOLKEREGISTERIDENT,
    NPID,
    ORGNR,
    SAMHANDLERNR,
}
