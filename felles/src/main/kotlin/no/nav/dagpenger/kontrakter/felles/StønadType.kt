package no.nav.dagpenger.kontrakter.felles

import com.fasterxml.jackson.annotation.JsonCreator

sealed interface StønadType {
    fun tilFagsystem(): Fagsystem

    fun tilEnum(): Enum<*> {
        return if (this is StønadTypeDagpenger) {
            this
        } else {
            this as StønadTypeTiltakspenger
        }
    }

    companion object {
        @JsonCreator
        @JvmStatic
        fun deserialize(json: String): StønadType? {
            return Result.runCatching { StønadTypeDagpenger.valueOf(json) }
                .getOrElse {
                    Result.runCatching { StønadTypeTiltakspenger.valueOf(json) }
                        .getOrNull()
                }
        }
    }

}

enum class StønadTypeDagpenger : StønadType {
    DAGPENGER_ARBEIDSSOKER_ORDINAER,
    DAGPENGER_PERMITTERING_ORDINAER,
    DAGPENGER_PERMITTERING_FISKEINDUSTRI,
    DAGPENGER_EOS;

    override fun tilFagsystem(): Fagsystem = Fagsystem.Dagpenger
}

enum class StønadTypeTiltakspenger : StønadType {
    TILTAKSPENGER,
    TILTAKSPENGER_BARNETILLEGG_HOYERE_UTDANNING,
    TILTAKSPENGER_BARNETILLEGG_JOBBKLUBB_2009,
    TILTAKSPENGER_UTDANNING,
    TILTAKSPENGER_AVKLARING_ANDRE_GRUPPER,
    TILTAKSPENGER_SEMESTERAVGIFT_OPPFOLGING_ANDRE_GRUPPER,
    TILTAKSPENGER_BARNETILLEGG_ENKELTPLASS_AMO,
    TILTAKSPENGER_HOYERE_UTDANNING,
    TILTAKSPENGER_JOBBKLUBB_FRA_2009,
    TILTAKSPENGER_BARNETILLEGG_GRUNNSKOLE_VGS_OG_HOYERE_YRKESFAG,
    TILTAKSPENGER_BARNETILLEGG_IPS,
    TILTAKSPENGER_BARNETILLEGG_ARBEIDSTRENINGSTILTAK,
    TILTAKSPENGER_ENKELTPLASS_VGS_ELLER_HOYERE_UTDANNING,
    TILTAKSPENGER_EKSAMENSGEBYR_GRUNNSKOLE_VGS_OG_HOYERE_UTDANNING,
    TILTAKSPENGER_GRUPPE_VGS_ELLER_HOYERE_UTDANNING,
    TILTAKSPENGER_SKOLEPENGER_GRUPPE_AMO,
    TILTAKSPENGER_BARNETILLEGG_GRUPPE_AMO,
    TILTAKSPENGER_INKLUDERINGSTILSKUDD,
    TILTAKSPENGER_SEMESTERAVGIFT_ENKELT_VGS_OG_HOYERE_UTDANNING,
    TILTAKSPENGER_SKOLEPENGER_HOYERE_UTDANNING,
    TILTAKSPENGER_BARNETILLEGG_UTDANNING,
    TILTAKSPENGER_SKOLEPENGER_ARBEIDSTRNINGSTILTAK,
    TILTAKSPENGER_BARNETILLEGG_OPPFOLGING_ANDRE_GRUPPER,
    TILTAKSPENGER_EKSAMENSGEBYR_AMO,
    TILTAKSPENGER_FORSOK_LENGRE_VARIGHET,
    TILTAKSPENGER_UTVIDET_AVKLARING_OG_OPPFOLGING,
    TILTAKSPENGER_BARNETILLEGG_ARB_R_REHAB_ANDRE_GR_DAG,
    TILTAKSPENGER_MENTOR,
    TILTAKSPENGER_TILSYNSTILLEGG_AMO,
    TILTAKSPENGER_SKOLEPENGER_GRUPPE_VGS_OG_HOYERE,
    TILTAKSPENGER_SKOLEPENGER_ENKELTPLASS_VGS_OG_HOYERE,
    TILTAKSPENGER_BARNETILLEGG_AVKLARING_ANDRE_GRUPPER,
    TILTAKSPENGER_INDIVIDUELL_JOBBSTOTTE,
    TILTAKSPENGER_EKSAMENSGEBYR_ENKELTPLASS_AMO,
    TILTAKSPENGER_SEMESTERAVGIFT_ENKELTPLASS_AMO,
    TILTAKSPENGER_DIGITAL_JOBBKLUBB,
    TILTAKSPENGER_EKSAMENSGEBYR_FORSOK_FAG_YRKESOPPLAERING,
    TILTAKSPENGER_ARBEIDSTRENINGSTILTAK,
    TILTAKSPENGER_RES_BASERT_FINANS_FORM_BISTAND,
    TILTAKSPENGER_BARNETILLEGG_ARBEIDSFORBEREDENDE,
    TILTAKSPENGER_EKSAMESNSGEBYR_GR_AMO,
    TILTAKSPENGER_ARBEIDSMARKEDSTILTAK,
    TILTAKSPENGER_BARNETILLEGG_UTV_OPPF_OPPLAERING,
    TILTAKSPENGER_BARNETILLEGG_IPS_UNG,
    TILTAKSPENGER_EKSAMENSGEBYR_HOYERE_UTDANNING,
    TILTAKSPENGER_BARNETILSYN_ENKELPLASS_VGS_OG_HOYERE_YRKESFAG,
    TILTAKSPENGER_GRUPPE_AMO,
    TILTAKSPENGER_BARNETILLEGG_AMO,
    TILTAKSPENGER_SKOLEPENGER_ARBEIDSMARKEDSTILTAK,
    TILTAKSPENGER_DAGLIG_REISE_AMO,
    TILTAKSPENGER_BARNETILLEGG_UTVIDET_AVKLARING_OPPFOLGING,
    TILTAKSPENGER_SEMESTERAVGIFT_HOYERE_UTDANNING,
    TILTAKSPENGER_EKSAMENSGEBYR_ENKELT_VGS_OG_HOYERE_UTDANNING,
    TILTAKSPENGER_AMO,
    TILTAKSPENGER_OPPFOLGING_ANDRE_GRUPPER,
    TILTAKSPENGER_EKSAMENSGEBYR_ARBEIDSFORBEREDENDE,
    TILTAKSPENGER_SKOLEPENGER_ENKELTPLASS_AMO,
    TILTAKSPENGER_INDIVIDUELL_JOBBSTOTTE_UNG,
    TILTAKSPENGER_EKSAMENSGEBYR_ARBEIDSTRENINGSTILTAK,
    TILTAKSPENGER_UTVIDET_OPPFOLGIN_I_OPPLAERING,
    TILTAKSPENGER_SKOLEPENGER_UTDANNING,
    TILTAKSPENGER_BARNETILLEGG_DIGITAL_JOBBKLUBB,
    TILTAKSPENGER_ENKELTPLASS_AMO,
    TILTAKSPENGER_SKOLEPENGER_ARBEIDSFORBEREDENDE,
    TILTAKSPENGER_DAGLIG_REISE_AVKLARING_SKJERMET_VIRKSOMHET,
    TILTAKSPENGER_BARNETILLEGG_FORSOK_LENGRE_VARIGHET,
    TILTAKSPENGER_SKOLEPENGER_FORSOK_HOYERE_UTDANNING,
    TILTAKSPENGER_ARBEIDSRETTET_REHAB_ANDRE_GR__DAG,
    TILTAKSPENGER_ARBEIDSFORBEREDENDE;

    override fun tilFagsystem(): Fagsystem = Fagsystem.Tiltakspenger
}