import { inject } from "@angular/core";
import { ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot } from "@angular/router";
import { Dica } from "src/app/models/dica.model";
import { DicaService } from "src/app/services/dica.service";

export const dicaResolver: ResolveFn<Dica> = 
    (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
        return inject(DicaService).findById(route.paramMap.get('id')!);
    };