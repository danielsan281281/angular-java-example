import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  //FIXME: 
  rootURL = 'http://localhost:8081/api';

  getUsers() {
    return this.http.get(this.rootURL + '/users');
  }

  addUser(user: any, id: number) {
	  user.id = id;
	  return this.http.post(this.rootURL + '/user', user);
  }

}
