import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class AccueilService {

  constructor(private http: HttpClient, private appConfig: AppConfigService) { }
}
