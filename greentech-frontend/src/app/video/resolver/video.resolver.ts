import { inject } from "@angular/core";
import { ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot } from "@angular/router";
import { Video } from "src/app/models/video.model";
import { VideoService } from "src/app/services/video.service";

export const videoResolver: ResolveFn<Video> = 
    (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
        return inject(VideoService).findById(route.paramMap.get('id')!);
    };