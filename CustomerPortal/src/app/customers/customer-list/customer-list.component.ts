import { Component, OnInit } from '@angular/core';
import { Customers } from 'src/app/models/customers.model';
import { CustomersService } from '../customers.service';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css'],
  providers: [CustomersService]
  

})
export class CustomerListComponent implements OnInit{

  public customerList: Customers[];
  public sample: string;

  constructor(private customersservice: CustomersService) { 

    this.customersservice.getCustomers().subscribe((data: Customers[]) =>{
      this.customerList = data;
    });
      
      //customerList => this.customerList = customerList);

  }

  ngOnInit(){

  }

  public getCustomers() {
  this.sample = "sample";
    console.log();

    //this.customersservice.getCustomers().subscribe(customerList => this.customerList = customerList);

  }

}
