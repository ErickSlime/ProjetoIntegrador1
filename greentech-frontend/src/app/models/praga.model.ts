import { Especie } from "./especie.model";
import { Prevencao } from "./prevencao.model";

export class Praga {
    id!: number;
    nome!: string;
    nomeImagem!: string;
    descricao!: string;
    prevencao!: Prevencao[];
    especie!: Especie;
}