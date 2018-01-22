import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class AuthenticationService {
  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http.post<any>('http://localhost:8090/login', {username: username, password: password}, httpOptions)
    // .map(user => {
    //     // login successful if there's a jwt token in the response
    //     if (user && user.token) {
    //         // store user details and jwt token in local storage to keep user logged in between page refreshes
    //         localStorage.setItem('currentUser', JSON.stringify(user));
    //     }
    //
    //     return user;
    // });
    //   .map(token => {
    //     localStorage.setItem('token', JSON.stringify(token));
    //   })
    // ;
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
