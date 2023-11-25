import { inject } from "@angular/core";
import { ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot } from "@angular/router";
import { Planta } from "src/app/models/planta.model";
import { PlantaService } from "src/app/services/planta.service";

export const plantaResolver: ResolveFn<Planta> = 
    (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
        return inject(PlantaService).findById(route.paramMap.get('id')!);
    };