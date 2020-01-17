import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customers} from '../models/customers.model';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  constructor(private httpService: HttpClient) { }

  public getCustomers(){ 
     
    return this.httpService.get('http://localhost:8080/customers');

    //return this.httpService.get<Customers[]>('http://localhost:8080/customers').pipe(
    //  map(data  => data.map(data => new Customers().deserialize(data)))
   // );
  }

}
