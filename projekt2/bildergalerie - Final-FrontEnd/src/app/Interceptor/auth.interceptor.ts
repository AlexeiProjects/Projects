import { HttpEvent, HttpHandlerFn, HttpInterceptorFn, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";



export function authInterceptor (req: HttpRequest<unknown>, next: HttpHandlerFn): Observable<HttpEvent<unknown>> {
    console.log("interceptor test")
    const token  = localStorage.getItem("token") ?? "";
    console.log(token)
    const modifiedReq = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${token}`),
    });

    return next(modifiedReq);
};

/*
export const authInterceptor: HttpInterceptorFn = (request,next) =>{
    console.log("interceptor test")
    const token  = localStorage.getItem("jwt") ?? "";
    request = request.clone({
        setHeaders:{
            Authorization: `Bearer ${token}`
        },

    });
    return next(request);
}
*/

