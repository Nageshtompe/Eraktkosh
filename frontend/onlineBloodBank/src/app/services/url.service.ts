import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  constructor() { }

  baseUrl='http://localhost:8080/'
  // baseUrl='http://13.232.198.136:8080/bloodbank07/'


  getUrl()
  {
    return this.baseUrl;
  }


}
