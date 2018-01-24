import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {
  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http
      .post<any>('http://localhost:8090/login', {username: username, password: password}, {
        headers: new HttpHeaders({'Content-Type': 'application/json'}),
        observe: 'response'
      });

  }

  public logout(): void {
    // remove user from local storage to log user out
    localStorage.removeItem('token');
  }

  // Check whether the token is expired and return
  // true or false
  isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    if (token) {
      return true;
    }
    return false;
  }
}
