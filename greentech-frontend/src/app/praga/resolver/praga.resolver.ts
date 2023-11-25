import { inject } from "@angular/core";
import { ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot } from "@angular/router";
import { Praga } from "src/app/models/praga.model";
import { PragaService } from "src/app/services/praga.service";

export const pragaResolver: ResolveFn<Praga> = 
    (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
        return inject(PragaService).findById(route.paramMap.get('id')!);
    };