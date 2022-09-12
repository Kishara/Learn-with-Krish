import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderModel } from './orderModel';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseURL = "http://localhost:8080/api/v1/orders";
  constructor(private httpClient:HttpClient) { }

  getAllOrders():Observable<OrderModel[]>{
    return this.httpClient.get<OrderModel[]>(`${this.baseURL}`);
  }

  createOrder(order:OrderModel):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,order);
  }

  getOrderById(id:number): Observable<OrderModel[]>{
    return this.httpClient.get<OrderModel[]>(`${this.baseURL}/${id}`);
  }

  getOrderComplete(id:number,status:string){
    return this.httpClient.put(`${this.baseURL}/${id}/${status}`,"");
}

}
