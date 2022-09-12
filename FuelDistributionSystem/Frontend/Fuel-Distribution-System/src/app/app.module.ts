import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { CheckOrdersComponent } from './check-orders/check-orders.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { OrderReceivedComponent } from './order-received/order-received.component';
import { DispatchComponent } from './dispatch/dispatch.component';


@NgModule({
  declarations: [
    AppComponent,
    AllOrdersComponent,
    CheckOrdersComponent,
    CreateOrderComponent,
    OrderReceivedComponent,
    DispatchComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
