import { Component, OnInit } from '@angular/core';
import { Dispatch } from '../dispatch';
import { DispatchService } from '../dispatch.service';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-dispatch',
  templateUrl: './dispatch.component.html',
  styleUrls: ['./dispatch.component.css']
})
export class DispatchComponent implements OnInit {

  dispatches!: Dispatch[];
  constructor(private dispatchService: DispatchService, private orderService:OrderService) { }

  ngOnInit(): void {
    this.getAllOrders();
  }

  private getAllOrders(){
    this.dispatchService.getAllOrders().subscribe(data =>{
      this.dispatches = data;
      console.log(data);
    })
  }

  dispatchOrder(orderId:number){
    this.orderService.getOrderComplete(orderId,"Dispatched").subscribe(data =>{
      console.log(data);
    },
    error => console.log(error));
  }

}
