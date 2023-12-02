import { Especie } from "./especie.model";
import { Praga } from "./praga.model";
import { TipoSolo } from "./tipo-solo.model";

export class Planta {
    id!: number;
    nome!: string;
    nomeImagem!: string;
    descricao!: string;
    tipoSolo!: TipoSolo;
    especie!: Especie;
    pragas!: Praga[];
}