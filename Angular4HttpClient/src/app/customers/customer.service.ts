import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders } from '@angular/common/http';

import { Customer } from './customer';

@Injectable()
export class CustomerService {

  private baseUrl = 'http://localhost:8081/rest';



  constructor(private http: HttpClient) { }

  getCustomer(id: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}` + `/getCustomer/${id}`);
  }

  createCustomer(customer: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/saveCustomer`, customer);
  }

  updateCustomer(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/updateCustomer/${id}`, value);
  }

  deleteCustomer(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}`+`/deleteCustomer/${id}`, { responseType: 'text' });
  }

  getCustomersList(query = {}): Observable<any> {
    return this.http.get(`${this.baseUrl}` + `/customers`,httpOptions);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'xyzx'
  })
};
