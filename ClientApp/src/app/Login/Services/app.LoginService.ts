import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs'
import { catchError, tap } from 'rxjs/operators'
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { LoginModel } from '../Models/app.LoginModel';
import { Router } from '@angular/router';

@Injectable({
    providedIn: 'root'
})

export class LoginService {
    public token: string;
    constructor(private _http: HttpClient, private _Route: Router) 
    {

    }
    private apiUrl = "	http://localhost:3000/api/Authenticate/";

    public validateLoginUser(loginmodel: LoginModel)
    {
        let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        return this._http.post<any>(this.apiUrl, loginmodel, { headers: headers })
            .pipe(tap(data => 
            {
                var dataObj = data;
                
                if (data[0].Usertype == "2") {
                    dataObj = data[0];
                    
                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify({ Username: loginmodel.Username }));
                    
                }
                else if (data[0].Usertype == "1") {
                    dataObj = data[0];
                    
                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('AdminUser', JSON.stringify({ Username: loginmodel.Username}));
                    //console.log(JSON.parse(localStorage.getItem('AdminUser')));
                    
                }
                // return true to indicate successful login
                return dataObj;
            }),
                catchError(this.handleError)
            );
    }

    LogoutUser() {
        localStorage.removeItem('currentUser');
    }

    private handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
        } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            console.error(`Backend returned code ${error.status}, ` + `body was: ${error.error}`);
        }
        // return an observable with a user-facing error message
        return throwError('Something bad happened; please try again later.');
    };
}
