import { Input } from "@angular/core";
import { User } from "./user";

export class Outlet {
    id:number|any;
    outletname:String|any;
    ocode:number|any;
   pcode: any[]=[];
   ousername:any;
    userdto:User=new User();
}

